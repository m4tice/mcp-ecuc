#!/usr/bin/env python3

"""
MCP ECUC Server - Python Implementation with FastMCP

An MCP (Model Context Protocol) server that provides AI assistants with access to 
ECUC (ECU Configuration) data extraction functionality using FastMCP.
"""

import asyncio
import os
import subprocess
import tempfile
from pathlib import Path
from typing import Any, Dict, List, Optional

from fastmcp import FastMCP

# Initialize the FastMCP server
mcp = FastMCP("ECUC Configuration Server")

class EcucExtractor:
    """Helper class for ECUC data extraction using Java utilities"""
    
    def __init__(self):
        self.ecuc_project_path = os.getenv("ECUC_PROJECT_PATH", ".")
        self.java_extractor_class = "EcucExtractor"
    
    async def execute_java_extractor(self, command: str) -> str:
        """
        Execute Java ECUC extractor with a custom Java snippet
        
        Args:
            command: The command/operation to execute
            
        Returns:
            The output from the Java extractor
        """
        try:
            # Compile Java files first
            compile_process = await asyncio.create_subprocess_exec(
                "javac", "-cp", "src", "src/EcucExtractor.java", "src/ecuc/*.java", 
                "src/can/*.java", "src/com/*.java", "src/pdur/*.java", "src/model/*.java",
                cwd=self.ecuc_project_path,
                stdout=asyncio.subprocess.PIPE,
                stderr=asyncio.subprocess.PIPE
            )
            
            compile_stdout, compile_stderr = await compile_process.communicate()
            
            if compile_process.returncode != 0:
                return f"Compilation failed: {compile_stderr.decode()}"
            
            # Execute the Java extractor
            process = await asyncio.create_subprocess_exec(
                "java", "-cp", "src", self.java_extractor_class, command,
                cwd=self.ecuc_project_path,
                stdout=asyncio.subprocess.PIPE,
                stderr=asyncio.subprocess.PIPE
            )
            
            stdout, stderr = await process.communicate()
            
            if process.returncode == 0:
                return stdout.decode()
            else:
                return f"Error: {stderr.decode()}"
                
        except Exception as e:
            return f"Failed to execute Java extractor: {str(e)}"

# Create extractor instance
extractor = EcucExtractor()

@mcp.tool()
async def extract_ecuc_data(arxml_file_path: str) -> str:
    """
    Extract ECUC configuration data from an ARXML file.
    
    Args:
        arxml_file_path: Path to the ARXML file to extract data from
        
    Returns:
        Extracted ECUC configuration data in JSON format
    """
    if not os.path.exists(arxml_file_path):
        return f"Error: File {arxml_file_path} does not exist"
    
    command = f"extractEcucData {arxml_file_path}"
    return await extractor.execute_java_extractor(command)

@mcp.tool()
async def extract_pdu_info(arxml_file_path: str) -> str:
    """
    Extract PDU (Protocol Data Unit) information from an ARXML file.
    
    Args:
        arxml_file_path: Path to the ARXML file to extract PDU info from
        
    Returns:
        PDU information in JSON format
    """
    if not os.path.exists(arxml_file_path):
        return f"Error: File {arxml_file_path} does not exist"
    
    command = f"extractPduInfo {arxml_file_path}"
    return await extractor.execute_java_extractor(command)

@mcp.tool()
async def extract_can_config(arxml_file_path: str) -> str:
    """
    Extract CAN (Controller Area Network) configuration from an ARXML file.
    
    Args:
        arxml_file_path: Path to the ARXML file to extract CAN config from
        
    Returns:
        CAN configuration data in JSON format
    """
    if not os.path.exists(arxml_file_path):
        return f"Error: File {arxml_file_path} does not exist"
    
    command = f"extractCanConfig {arxml_file_path}"
    return await extractor.execute_java_extractor(command)

@mcp.tool()
async def extract_com_config(arxml_file_path: str) -> str:
    """
    Extract COM (Communication) configuration from an ARXML file.
    
    Args:
        arxml_file_path: Path to the ARXML file to extract COM config from
        
    Returns:
        COM configuration data in JSON format
    """
    if not os.path.exists(arxml_file_path):
        return f"Error: File {arxml_file_path} does not exist"
    
    command = f"extractComConfig {arxml_file_path}"
    return await extractor.execute_java_extractor(command)

@mcp.tool()
async def extract_pdur_config(arxml_file_path: str) -> str:
    """
    Extract PduR (PDU Router) configuration from an ARXML file.
    
    Args:
        arxml_file_path: Path to the ARXML file to extract PduR config from
        
    Returns:
        PduR configuration data in JSON format
    """
    if not os.path.exists(arxml_file_path):
        return f"Error: File {arxml_file_path} does not exist"
    
    command = f"extractPduRConfig {arxml_file_path}"
    return await extractor.execute_java_extractor(command)

@mcp.tool()
async def list_ecuc_modules(arxml_file_path: str) -> str:
    """
    List all ECUC modules available in an ARXML file.
    
    Args:
        arxml_file_path: Path to the ARXML file to list modules from
        
    Returns:
        List of available ECUC modules
    """
    if not os.path.exists(arxml_file_path):
        return f"Error: File {arxml_file_path} does not exist"
    
    command = f"listModules {arxml_file_path}"
    return await extractor.execute_java_extractor(command)

@mcp.tool()
async def validate_ecuc_config(arxml_file_path: str) -> str:
    """
    Validate ECUC configuration in an ARXML file.
    
    Args:
        arxml_file_path: Path to the ARXML file to validate
        
    Returns:
        Validation results and any errors found
    """
    if not os.path.exists(arxml_file_path):
        return f"Error: File {arxml_file_path} does not exist"
    
    command = f"validateConfig {arxml_file_path}"
    return await extractor.execute_java_extractor(command)

@mcp.resource("file://{path}")
async def read_arxml_file(path: str) -> str:
    """
    Read and return the contents of an ARXML file.
    
    Args:
        path: Path to the ARXML file
        
    Returns:
        Contents of the ARXML file
    """
    try:
        with open(path, 'r', encoding='utf-8') as f:
            return f.read()
    except Exception as e:
        return f"Error reading file: {str(e)}"

if __name__ == "__main__":
    # Run the FastMCP server
    mcp.run()
