#!/bin/bash

# Get the directory where this script is located
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"
mkdir -p bin
javac -d bin -cp src src/EcucExtractor.java src/model/*.java src/ecuc/*.java src/can/*.java src/com/*.java src/pdur/*.java && java -cp bin EcucExtractor
