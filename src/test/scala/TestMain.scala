import org.scalatest.FunSuite

/**
  * Created by DGOODWIN on 22/08/2017.
  */
class TestMain extends FunSuite {
  test("Creating a menu item"){
    // Test creating a menu item object
    val item = new MItem("Test", false, 10, false);
    assert(item.name == "Test" & item.price == 10 & item.hot == false & item.drink == false);
  }
  test("Menu Initialise"){
    // Test menu when initialised has the 4 items needed
    val menu = Main.initMenu;
    assert(menu.length == 4);
  }
  test("Sum Cheese Sandwich"){
    // Test a bill with just cheese sandwich returns value of cheese sandwich
    val bill = Main.getBill("Cheese Sandwich");
    assert(bill == 2.2); // Food but cold, (2 + 10% service)
  }
  test("Sum Coffee&Cola"){
    // Test a bill with coffee and cola (2 items) returns value of both
    val bill = Main.getBill("Cola", "Coffee");
    assert(bill == 1.5); // All drinks no service
  }
  test("Sum All Items"){
    // Test a bill with all valid items from menu
    val bill = Main.getBill("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich");
    assert(bill == 9.6); // 8 + 20% service
  }
  test("Sum Invalid Item"){
    // Test a bill for an item not on the list
    val bill = Main.getBill("Lemonade");
    assert(bill == 0);
  }
  test("Hot food and drink"){
    // Test a bill with two items, both drinks
    val bill = Main.getBill("Cola", "Steak Sandwich")
    assert(bill == 6); // 5 + 20% service
  }
  test("Service charge over 20"){
    // Test a bill where the service charge is limited to 20
    val bill = Main.getBill(
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich");
    assert(bill == 128) // 108 + 20% limited to 20 (21.96)
  }
}
