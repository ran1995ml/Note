PWD="$(pwd)"
WHEREAMI="$(dirname "$0")"
WHEREAMI="$(cd "$WHEREAMI" && pwd)"
echo $WHEREAMI