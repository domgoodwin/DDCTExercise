/**
  * Created by DGOODWIN on 22/08/2017.
  */
object Main {
  def initMenu={
    val cola = new MItem("Cola", false, 0.50);
    val coffee = new MItem("Coffee", true, 1);
    val cheeseSand = new MItem("Cheese Sandwich", false, 2);
    val steakSand = new MItem("Steak Sandwich", false, 4.50);
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
    val total = items.map(_.price).sum;

    // Return total
    total;
  }
}
