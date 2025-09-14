# MCP ECUC Server - FastMCP Implementation

This is a Python implementation of the MCP ECUC Server using FastMCP, a simplified framework for building Model Context Protocol servers.

## Features

The FastMCP implementation provides the same functionality as the TypeScript version:

- **extract_ecuc_data**: Extract ECUC configuration data from ARXML files
- **extract_pdu_info**: Extract PDU (Protocol Data Unit) information
- **extract_can_config**: Extract CAN (Controller Area Network) configuration
- **extract_com_config**: Extract COM (Communication) configuration
- **extract_pdur_config**: Extract PduR (PDU Router) configuration
- **list_ecuc_modules**: List all available ECUC modules
- **validate_ecuc_config**: Validate ECUC configuration
- **read_arxml_file**: Read ARXML file contents (resource)

## Installation

### Option 1: Using the install script (Recommended)

```bash
python install_fastmcp.py
```

### Option 2: Manual installation

```bash
# Install FastMCP
pip install fastmcp

# Or install from GitHub if PyPI version is not available
pip install git+https://github.com/jlowin/fastmcp.git

# Install other requirements
pip install -r requirements.txt
```

## Usage

### Running the Server

```bash
python mcp_ecuc_server_fastmcp.py
```

### Configuration

Set the `ECUC_PROJECT_PATH` environment variable to specify the path to your ECUC project:

```bash
export ECUC_PROJECT_PATH="/path/to/your/ecuc/project"
python mcp_ecuc_server_fastmcp.py
```

Or on Windows:
```cmd
set ECUC_PROJECT_PATH=C:\path\to\your\ecuc\project
python mcp_ecuc_server_fastmcp.py
```

## FastMCP Advantages

FastMCP provides several advantages over the standard MCP SDK:

1. **Simplified API**: Use decorators to define tools and resources
2. **Automatic type inference**: Function signatures automatically define tool schemas
3. **Less boilerplate**: Minimal setup code required
4. **Easy testing**: Built-in testing utilities
5. **Better error handling**: Automatic error formatting and handling

## Example Tool Usage

```python
@mcp.tool()
async def extract_ecuc_data(arxml_file_path: str) -> str:
    """
    Extract ECUC configuration data from an ARXML file.
    
    Args:
        arxml_file_path: Path to the ARXML file to extract data from
        
    Returns:
        Extracted ECUC configuration data in JSON format
    """
    # Implementation here
```

The `@mcp.tool()` decorator automatically:
- Registers the tool with the MCP server
- Creates the JSON schema from the function signature
- Handles errors and formatting
- Provides the tool description from the docstring

## Comparison with Standard MCP

| Feature | Standard MCP | FastMCP |
|---------|-------------|---------|
| Setup complexity | High | Low |
| Boilerplate code | Extensive | Minimal |
| Type safety | Manual | Automatic |
| Error handling | Manual | Built-in |
| Testing | Complex | Simple |
| Documentation | Manual | From docstrings |

## Testing

FastMCP includes built-in testing utilities:

```python
# Test the server
from fastmcp.testing import test_server

async def test_extract_ecuc_data():
    result = await test_server.call_tool("extract_ecuc_data", {
        "arxml_file_path": "test_file.arxml"
    })
    assert "error" not in result.lower()
```

## Project Structure

```
├── mcp_ecuc_server_fastmcp.py  # FastMCP implementation
├── mcp_ecuc_server.py          # Standard MCP implementation
├── install_fastmcp.py          # Installation script
├── requirements.txt            # Python dependencies
├── README-FastMCP.md          # This file
└── src/                       # Java source files
    ├── EcucExtractor.java
    ├── ecuc/
    ├── can/
    ├── com/
    └── pdur/
```

## Development

To modify or extend the server:

1. Add new tools using the `@mcp.tool()` decorator
2. Add new resources using the `@mcp.resource()` decorator
3. Function signatures automatically define the tool schemas
4. Docstrings provide tool descriptions

Example:
```python
@mcp.tool()
async def my_new_tool(param1: str, param2: int = 10) -> str:
    """
    Description of what this tool does.
    
    Args:
        param1: Required string parameter
        param2: Optional integer parameter (default: 10)
        
    Returns:
        Result description
    """
    # Implementation
    return f"Result for {param1} with {param2}"
```

## Troubleshooting

### FastMCP not found
If you get `Import "fastmcp" could not be resolved`:
1. Run the installation script: `python install_fastmcp.py`
2. Or install manually: `pip install fastmcp`

### Java compilation errors
Ensure you have Java installed and the Java source files are properly structured in the `src/` directory.

### Port conflicts
FastMCP runs on stdio by default, so there should be no port conflicts.

## License

This project follows the same license as the original MCP ECUC Server.
