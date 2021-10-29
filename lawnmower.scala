//creating "lawnmower" class
  class lawnmower(var x : Int, var y : Int, var facing : String, val x_plan : Int, val y_plan : Int) {
    var x_ : Int = x
    var y_ : Int = y
    var facing_ : String = facing

    var position = s"$x_ $y_ $facing_" //this will help print the position of the lawnmower

    def move_forward(): Unit ={ //moves by 1 unit, depending on which way the lawnmower is facing, and if it is already on a field border
      if ((facing_ == "N") && (y_ < y_plan)){
        y_ = y_ + 1
        position = s"$x_ $y_ $facing_"
      } else if ((facing_ == "S") && (y_ > 0)){
        y_ = y_ - 1
        position = s"$x_ $y_ $facing_"
      } else if ((facing_ == "E") && (x_ < x_plan)){
        x_ = x_ + 1
        position = s"$x_ $y_ $facing_"
      } else if ((facing_ == "W") && (x_ > 0)) {
        x_ = x_ - 1
        position = s"$x_ $y_ $facing_"
      }
    }

    def rotate(handside: String): Unit ={ //rotates the lawnmower by 90°, either on the right (D) or on the left (G)
      var new_facing = "O"
      if (handside == "G"){
        if (facing_ == "N"){
          new_facing = "W"
        } else if (facing_ == "S"){
          new_facing = "E"
        } else if (facing_ == "E"){
          new_facing = "N"
        } else if (facing_ == "W") {
          new_facing = "S"
        }
      }
      if (handside == "D"){
        if (facing_ == "N"){
          new_facing = "E"
        } else if (facing_ == "S"){
          new_facing = "W"
        } else if (facing_ == "E"){
          new_facing = "S"
        } else if (facing_ == "W") {
          new_facing = "N"
        }
      }
      facing_ = new_facing
      position = s"$x_ $y_ $facing_"
    }
}
