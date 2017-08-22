/**
  * Created by DGOODWIN on 22/08/2017.
  */
object Main {
  def initMenu={
    val cola = new MItem("Cola", false, 0.50, true);
    val coffee = new MItem("Coffee", true, 1, true);
    val cheeseSand = new MItem("Cheese Sandwich", false, 2, false);
    val steakSand = new MItem("Steak Sandwich", false, 4.50, false);
    List(cola, coffee, cheeseSand, steakSand);
  }

  def getBill (choices:String*)={
    // Initialise menu with items on it
    val menuFull = initMenu;

    // Loop through both lists returning matches
    val items = for {
      menuItem<-menuFull
      choice<-choices
      if choice == menuItem.name
    } yield menuItem

    // Get total of chosen items
    val total = {
      // Total base sum, no added charges
      items.map(_.price).sum


    };

    // If all items are drinks no service charge applied
    // When purchased items include any food apply a service charge of 10% to the total bill (rounded to 2 decimal places)
    // When purchased items include any hot food apply a service charge of 20% to the total bill with a maximum £20 service charge


    // Return total
    total;
  }
}
