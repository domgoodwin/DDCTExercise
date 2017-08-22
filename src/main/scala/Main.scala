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
      val baseTotal = items.map(_.price).sum;
      // Check if bill contains any food
      val containsFood = items.exists(_.drink == false);
      // Check if bill contains any hot food items
      val containsHot = items.exists(_.hot == true);

      // Get rate of service charge
      val serviceCharge = (containsFood,containsHot) match{
        case (true,true) => 1.2; // Food and Hot - 20%
        case (true, _) => 1.1; // Food and not hot - 10%
        case (_,_) => 1; // Just drinks 0%
      }
      baseTotal * serviceCharge;
    };
    // Return total
    total;
  }
}
