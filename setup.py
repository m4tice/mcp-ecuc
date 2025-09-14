#!/usr/bin/env python3

from setuptools import setup, find_packages

setup(
    name="mcp-ecuc-server",
    version="1.0.0",
    description="MCP server that exposes ECUC (ECU Configuration) data extraction functionality",
    author="Your Name",
    license="MIT",
    packages=find_packages(),
    install_requires=[
        "mcp>=1.0.0",
    ],
    python_requires=">=3.8",
    entry_points={
        "console_scripts": [
            "mcp-ecuc-server=mcp_ecuc_server:main",
        ],
    },
    keywords=["mcp", "ecuc", "automotive", "server"],
    classifiers=[
        "Development Status :: 4 - Beta",
        "Intended Audience :: Developers",
        "License :: OSI Approved :: MIT License",
        "Programming Language :: Python :: 3",
        "Programming Language :: Python :: 3.8",
        "Programming Language :: Python :: 3.9",
        "Programming Language :: Python :: 3.10",
        "Programming Language :: Python :: 3.11",
        "Programming Language :: Python :: 3.12",
    ],
)
