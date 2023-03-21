#!/usr/bin/env python3

import argparse
import requests
import json
import re
import datetime

# This is used to check whether the druidLayout.json file takes effect after update.
#     1.The number of partition is equal to the count of active task.
#     2.The metricsSpec contains new added metrics.
#
#
# Usage:
#     python3 druid_supervisor_check.py --url DRUID_CONSOLE_URL --metrics NEW_ADDED_METRICS --log LOG_FILE_PATH --datasource DATASOURCE
#
#
# Samples:
#     * show help
#         python3 druid_supervisor_check.py -h
#         usage: python3 druid_supervisor_check.py [-h] --url DRUID_CONSOLE_URL --metrics NEW_ADDED_METRICS [--file LOG_FILE_PATH]
#
#     * optional arguments:
#         -h, --help  show this help message and exit
#         --log      The path of log file.
#
#     * required arguments:
#       --url        The druid console url. eg, --url ondemand-druid.iad1.prod.conviva.com:8888
#       --metrics    The metrics need to be checked. eg, --metrics life.sessionTimeMs life.joinTimeMs
#       --datasource The datasource needs to be checked. eg, --datasource ad_experience experience_insights

# Examples:
#     Check IAD-PROD druid cluster, the druid console is http://ondemand-druid.iad1.prod.conviva.com:8888/unified-console.html#ingestion,
#     and the new added metrics is life.sessionTimeMs and life.joinTimeMs. The log file is by default in the directory where the script is located.
#     python3 druid_supervisor_check.py --url ondemand-druid.iad1.prod.conviva.com:8888 --metrics life.sessionTimeMs life.joinTimeMs --datasource ad_experience experience_insights


def get_datasource_list():
    total_datasource_list = json.loads(requests.get(url + "/supervisor").content)
    datasource_list = [datasource for datasource in total_datasource_list if re.match(datasource_pattern, datasource) != None]
    return datasource_list


def get_datasource_info_dict(datasource):
    return json.loads(requests.get(url + "/supervisor/" + datasource + "/status").content)


def get_task_info_dict(task_id):
    return json.loads(requests.get(url + "/task/" + task_id).content)


def get_datasource_partition(datasource):
    datasource_info_dict = get_datasource_info_dict(datasource)
    partition = datasource_info_dict["payload"]["partitions"]
    return partition


def get_datasource_task_count(datasource):
    return len(get_datasource_task_list(datasource))


def get_datasource_task_list(datasource):
    datasource_info_dict = get_datasource_info_dict(datasource)
    datasource_task_list = datasource_info_dict["payload"]["activeTasks"]
    return datasource_task_list


def get_datasource_publishing_task_list(datasource):
    datasource_info_dict = get_datasource_info_dict(datasource)
    datasource_publishing_task_list = datasource_info_dict["payload"]["publishingTasks"]
    return datasource_publishing_task_list


def get_task_metrics(task_id):
    metrics_list = [metrics["name"] for metrics in get_task_info_dict(task_id)["payload"]["dataSchema"]["metricsSpec"]]
    return metrics_list


def check_task_not_contains_metrics(task_id, target_metrics_list):
    metrics_list = get_task_metrics(task_id)
    result = [metrics for metrics in target_metrics_list if metrics not in metrics_list]
    return result


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Test for argparse')
    parser.add_argument("--metrics", nargs='+', help="The metrics need to be checked, eg: --metrics life.sessionTimeMs life.joinTimeMs")
    parser.add_argument("--log", help="The path of log file.", default="./druid_supervisor_check.log")
    parser.add_argument("--url", help="The druid console url, eg:--url ondemand-druid.iad1.prod.conviva.com:8888")
    parser.add_argument("--datasource", nargs='+', help="The datasource needs to be checked, eg:--datasource ad_experience experience_insights")
    args = parser.parse_args()


    # url = "http://ondemand-druid.iad1.prod.conviva.com:8888/druid/indexer/v1"
    url = "http://" + args.url + "/druid/indexer/v1"
    datasource_pattern = "(" + "|".join(args.datasource) + ").session_summaries.PT1M.*"
    target_metrics_list = args.metrics
    log_file = args.log

    f = open(log_file, "w")

    datasource_list = sorted(get_datasource_list())

    for datasource in datasource_list:
        partition = get_datasource_partition(datasource)
        task_count = get_datasource_task_count(datasource)
        print("{}: checking datasource:{}".format(datetime.datetime.now(), datasource))
        f.write("{}: checking datasource:{}".format(datetime.datetime.now(), datasource))

        # check task count and partition
        if partition < task_count:
            print("{}: datasource: {}, partition: {}, task count: {}, value error".format(datetime.datetime.now(), datasource, partition, task_count))
            f.write("{}: datasource: {}, partition: {}, task count: {}\n".format(datetime.datetime.now(), datasource, partition, task_count))

        # check metricsSpec
        datasource_task_list = get_datasource_task_list(datasource)
        for task in datasource_task_list:
            task_id = task["id"]
            result = check_task_not_contains_metrics(task_id, target_metrics_list)
            if len(result) != 0:
                print("{}: datasource: {}, task id: {}, not found metrics: {}".format(datetime.datetime.now(), datasource, task_id, str(result)))
                f.write("{}: datasource: {}, task id: {}, not found metrics: {}\n".format(datetime.datetime.now(), datasource, task_id, str(result)))
        f.write("\n")

    f.close()