package com.ran.javase.designpattern.iterator;

/**
 * Waitress
 * 测试iterator
 * @author rwei
 * @since 2023/4/8 22:28
 */
public class Waitress {

    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator pancakeHouseMenuIterator = pancakeHouseMenu.createIterator();
        printMenu(pancakeHouseMenuIterator);
        Iterator dinerMenuIterator = dinerMenu.createIterator();
        printMenu(dinerMenuIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.print(menuItem.getName());
            System.out.print(menuItem.getPrice());
        }
    }
}
