// See README.md for license details.

package comb

import chisel3._
import chisel3.util._


class DecoderShortform extends Module {
  val io = IO(new Bundle {
    val x        = Input(UInt(2.W))
    val y       = Output(UInt(4.W)) 
  })

  io.y := 0.U
  io.y := 1.U << io.x
 
}

class DecoderInt extends Module {
  val io = IO(new Bundle {
    val x       = Input(UInt(2.W))
    val y       = Output(UInt(4.W)) 
  })


  io.y := 0.U

  switch (io.x) {
    is (0.U) {io.y := 1.U}
    is (1.U) {io.y := 2.U}
    is (2.U) {io.y := 4.U}
    is (3.U) {io.y := 8.U}
  } 
  
}

class DecoderBool extends Module {
  val io = IO(new Bundle {
    val x       = Input(UInt(2.W))
    val y       = Output(UInt(4.W)) 
  })


  io.y := 0.U

  switch (io.x) {
    is ("b00".U) {io.y := "b0001".U}
    is ("b01".U) {io.y := "b0010".U}
    is ("b10".U) {io.y := "b0100".U}
    is ("b11".U) {io.y := "b1000".U}
  } 
  
}


object PrintVerilog extends App {
    val s = getVerilogString(new DecoderBool()) 
    println(s)
}