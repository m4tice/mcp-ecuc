# MCP ECUC Server

An MCP (Model Context Protocol) server that provides AI assistants with access to ECUC (ECU Configuration) data extraction functionality.

## Overview

This project converts an existing Java ECUC data extraction system into an MCP server, enabling AI assistants to analyze automotive ECU configurations through standardized tools.

## Features

The MCP server provides the following tools for ECUC data extraction:

- **get_all_com_ipdus**: Extract all ComIPdus from the Com module with details
- **find_pdur_src_pdu_by_name**: Find specific PduR source PDUs by name
- **get_pdur_total_count**: Get total PDU count from the PduR module
- **get_canif_channels**: Access CanIf channel and PDU configurations
- **extract_custom_data**: Execute custom Java code snippets for data extraction

## Project Structure

```
mcpecuc/
├── src/
│   └── index.ts          # Main MCP server implementation
├── build/
│   └── index.js          # Compiled JavaScript
├── .vscode/
│   └── mcp.json          # VS Code MCP client configuration
├── package.json          # Node.js dependencies
├── tsconfig.json         # TypeScript configuration
└── README.md            # This file

../mcp-ecuc/             # Java ECUC extraction project
├── src/                 # Java source code
├── bin/                 # Compiled Java classes
└── compile_and_run_portable.sh
```

## Prerequisites

- Node.js 18 or higher
- Java Development Kit (JDK)
- The companion Java ECUC project in `../mcp-ecuc/`

## Installation

1. **Install Node.js dependencies:**
   ```bash
   npm install
   ```

2. **Build the TypeScript code:**
   ```bash
   npm run build
   ```

3. **Verify the Java ECUC project is accessible:**
   ```bash
   ls ../mcp-ecuc/compile_and_run_portable.sh
   ```

## Usage

### Running the MCP Server

The MCP server communicates via stdio and can be run directly:

```bash
ECUC_PROJECT_PATH="../mcp-ecuc" node build/index.js
```

### VS Code Integration

The project includes VS Code MCP client configuration. To use:

1. Install the MCP extension for VS Code
2. The server will be automatically configured via `.vscode/mcp.json`
3. Use the MCP tools in VS Code's AI assistant

### Manual Testing

You can test the server manually using JSON-RPC:

```bash
# Initialize the server
echo '{"jsonrpc": "2.0", "id": 1, "method": "initialize", "params": {"protocolVersion": "2024-11-05", "capabilities": {"tools": {}}, "clientInfo": {"name": "test-client", "version": "1.0.0"}}}' | ECUC_PROJECT_PATH="../mcp-ecuc" node build/index.js

# List available tools
echo '{"jsonrpc": "2.0", "id": 2, "method": "tools/list", "params": {}}' | ECUC_PROJECT_PATH="../mcp-ecuc" node build/index.js

# Extract ComIPdus
echo '{"jsonrpc": "2.0", "id": 3, "method": "tools/call", "params": {"name": "get_all_com_ipdus", "arguments": {}}}' | ECUC_PROJECT_PATH="../mcp-ecuc" node build/index.js
```

## Available Tools

### get_all_com_ipdus
Extracts all ComIPdus from the Com module.

**Parameters:** None

**Example Response:**
```
ComIPdu_Rx_ESP_19 (Direction: Rx, PDU: ESP_19)
ComIPdu_Tx_TSK_07 (Direction: Tx, PDU: TSK_07)
```

### find_pdur_src_pdu_by_name
Finds a specific PduR source PDU by name.

**Parameters:**
- `pduName` (string): Name of the PduR source PDU to find

**Example:**
```json
{"name": "find_pdur_src_pdu_by_name", "arguments": {"pduName": "PduRSrcPdu_ESP_19"}}
```

### get_pdur_total_count
Gets the total PDU count from the PduR module.

**Parameters:** None

### get_canif_channels
Gets all CanIf channels and their configurations.

**Parameters:** None

### extract_custom_data
Executes custom Java code snippets for data extraction.

**Parameters:**
- `extractionCode` (string): Java code snippet to execute

**Example:**
```json
{
  "name": "extract_custom_data",
  "arguments": {
    "extractionCode": "System.out.println(\"Custom extraction: \" + ecucDataModel.getCom().getComIPdus().size() + \" ComIPdus found\");"
  }
}
```

## Development

### Building
```bash
npm run build
```

### Project Structure
- `src/index.ts`: Main MCP server implementation with tool definitions
- Integration with existing Java ECUC code via child process spawning
- TypeScript with Zod schema validation for tool parameters

### Adding New Tools
1. Define the tool using `server.tool()` in `src/index.ts`
2. Add corresponding Java code generation in `executeJavaExtractor()`
3. Rebuild with `npm run build`

## Integration Details

The MCP server integrates with the existing Java ECUC extraction project by:

1. **Dynamic Code Generation**: Creates Java code snippets based on tool requests
2. **Process Spawning**: Executes the Java compilation and execution script
3. **Output Parsing**: Captures and returns Java program output
4. **Error Handling**: Provides meaningful error messages for failed operations

## Environment Variables

- `ECUC_PROJECT_PATH`: Path to the Java ECUC project (default: `../mcp-ecuc`)

## References

- [Model Context Protocol Specification](https://modelcontextprotocol.io/specification/latest)
- [TypeScript SDK Documentation](https://github.com/modelcontextprotocol/typescript-sdk)
- [MCP Server Development Guide](https://modelcontextprotocol.io/docs/develop/build-server)

## License

This project integrates with existing ECUC data extraction utilities and follows the same licensing terms.
