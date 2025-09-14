#!/bin/bash

PROJECT_DIR="/Users/m4tice/workspace/Java/mcp-ecuc"
cd "$PROJECT_DIR"
mkdir -p bin
javac -d bin -cp src src/EcucExtractor.java src/model/*.java src/ecuc/*.java src/can/*.java src/com/*.java src/pdur/*.java && java -cp bin EcucExtractor
