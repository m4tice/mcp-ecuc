#!/usr/bin/env python3

"""
Install script for FastMCP and dependencies
"""

import subprocess
import sys

def install_fastmcp():
    """Install FastMCP from PyPI or GitHub"""
    try:
        # Try installing from PyPI first
        print("Installing FastMCP from PyPI...")
        subprocess.check_call([sys.executable, "-m", "pip", "install", "fastmcp"])
        print("FastMCP installed successfully!")
    except subprocess.CalledProcessError:
        try:
            # If PyPI fails, try installing from GitHub
            print("PyPI installation failed, trying GitHub...")
            subprocess.check_call([
                sys.executable, "-m", "pip", "install", 
                "git+https://github.com/jlowin/fastmcp.git"
            ])
            print("FastMCP installed successfully from GitHub!")
        except subprocess.CalledProcessError:
            print("Failed to install FastMCP. Please install manually:")
            print("pip install fastmcp")
            print("or")
            print("pip install git+https://github.com/jlowin/fastmcp.git")
            return False
    return True

def install_requirements():
    """Install other requirements"""
    try:
        print("Installing other requirements...")
        subprocess.check_call([sys.executable, "-m", "pip", "install", "-r", "requirements.txt"])
        print("Requirements installed successfully!")
        return True
    except subprocess.CalledProcessError:
        print("Failed to install requirements")
        return False

if __name__ == "__main__":
    print("Setting up MCP ECUC Server with FastMCP...")
    
    success = install_fastmcp()
    if success:
        print("\nFastMCP installation completed!")
        print("\nYou can now run the server with:")
        print("python mcp_ecuc_server_fastmcp.py")
    else:
        print("\nInstallation failed. Please check the error messages above.")
