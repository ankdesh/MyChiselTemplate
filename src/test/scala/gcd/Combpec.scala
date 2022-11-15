// See README.md for license details.

package comb

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * testOnly gcd.GcdDecoupledTester
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'testOnly gcd.GcdDecoupledTester'
  * }}}
  */
class DecoderIntSpec extends AnyFreeSpec with ChiselScalatestTester {

  "Decoder should decode" in {
    test(new DecoderInt()) { dut =>
    
      dut.io.x.poke(1.U)
      dut.clock.step()

      dut.io.y.expect(2.U)
      
    }
  }
}

class DecodershortFormSpec extends AnyFreeSpec with ChiselScalatestTester {

  "Decoder should decode" in {
    test(new DecoderShortform()) { dut =>
    
      dut.io.x.poke(1.U)
      dut.clock.step()

      dut.io.y.expect(2.U)
      
    }
  }
}

