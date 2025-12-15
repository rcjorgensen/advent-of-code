package day11.ast

data class Input(val devices: List<Device>)
data class Device(val name: String, val targets: MutableList<Device> = mutableListOf())
