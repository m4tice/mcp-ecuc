#!/bin/bash

# Start the FastMCP ECUC Server in HTTP mode
echo "Starting FastMCP ECUC Server in HTTP mode..."
echo "Server will be available at: http://localhost:8000"
echo "Press Ctrl+C to stop the server"
echo ""

# Activate virtual environment if it exists
if [ -d ".venv" ]; then
    echo "Activating Python virtual environment..."
    source .venv/bin/activate
fi

# Set environment variables
export ECUC_PROJECT_PATH="$(pwd)"

# Start the server
python mcp_ecuc_server_fastmcp.py --http
