#!/bin/sh

set -xe

kotlinc -include-runtime Main.kt -d Main.jar
