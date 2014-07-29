package io.github.rmuhamedgaliev

import org.scalatest.{Matchers, FlatSpec}

class MainTest extends FlatSpec with Matchers {

  "A sum 1 and 2" should  " be 3" in {
    val main = Main;
    main.sum(1, 2) should be (3)
  }

}
