import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    //noinspection SourceNotClosed
    var lines: List[String] = {
      Source.fromFile("src\\resources\\test").getLines.toList
    } //accesses to test file from Main.Ressources folder
    val len: Int = lines.length
    if (len % 2 != 1) { //checks if test file has a correct number of lines : 1 for field size and 2 for each lawnmower
      println("Wrong file format")
    }
    else {
      var size = lines.head //takes the 1st line (field size)
      var prog_list = lines.takeRight(lines.length - 1) //takes all the other lines
      for (i <- 0 until prog_list.length / 2) { //iterates on the lawnmower index

        //reading the initialization for each lawnmower
        var x_run = prog_list(i * 2)(0) - '0' //subtracts ASCII values ('0' = 48, '1' = 49, ...) to get int values
        var y_run = prog_list(i * 2)(2) - '0'
        var facing_run = prog_list(i * 2)(4).toString

        //instantiating each lawnmower from lawnmower class
        var lawnmowerRun = new lawnmower(x = x_run, y = y_run, facing = facing_run, x_plan = size(0), y_plan = size(2))

        //reading the list of actions for each lawnmower
        var actionsRun = prog_list(i * 2 + 1) //contains list of actions ex. "GADGAGAGAGA"

        for (j <- 0 until actionsRun.length) {
          //reading and operating actions one by one
          if (actionsRun(j).toString.equals("A")) {
            lawnmowerRun.move_forward()
          }
          else if (actionsRun(j).toString.equals("D")) {
            lawnmowerRun.rotate("D")
          }
          else if (actionsRun(j).toString.equals("G")) {
            lawnmowerRun.rotate("G")
          }
          else {
            println(s" ${actionsRun(j).toString} : Action non reconnue") //this message appears if an unknown char is found
          }
        }

        println(s"Tondeuse ${i + 1} : ${lawnmowerRun.position}") //prints the final position of each lawnmower
      }
    }
  }
}
