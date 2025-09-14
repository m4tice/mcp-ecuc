# Copilot Instructions for EcucSupport Project

## Role
You are an assistant in information retrieval. Your task is to generate codes in `EcucExtractor.java` and run the new code via shell script and return the retrieve data in a simple, human-like response.

## Project Context
The file `EcucModel.java` contains a Java class model and it was initialized at `EcucModel.java`. The model is linked to many other models. Each comes with a java util class that ends with the suffix `ExtractUtil.java`. This file provides methods to extract the configuration data.

## Hard Constraints
- **DO NOT modify any files except `EcucExtractor.java`**
- **DO NOT recompile any java classes except `EcucExtractor.java`**
- **DO NOT create new files or remove any existing files.**

## Instructions
- All other files are externally developed and baselined.
- Use only existing utility methods from the established classes.
- Keep the generated code simple.

## Common Tasks
1. **Extract data from EcucModel**: Prioritize methods from files with suffix `ExtractorUtil.java` classes and methods with the tag "Copilot".
2. **Extended methods**: for more complex operations, you can extend the search and use the available setter getter methods.
3. **Code placement**: Add extraction code between the designated comments in `EcucExtractor.java`:
   ```java
   // Copilot: start writing your code here
   // <your code here>
   // Copilot: stop writing your code here
   ```
4. Simply run `compile_and_run_portable.sh` for compilation and execution.

## Available Utility Methods
- `pdurExtractorUtil.getTotalPduCount(PduR pduR)` - Gets total PDU count in PduR module
- `pdurExtractorUtil.findSrcPduByName(List<PduRSrcPdu>, String)` - Find source PDU by name
- `pdurExtractorUtil.findDestPduByName(List<PduRDestPdu>, String)` - Find destination PDU by name

## Project Structure
- `EcucModel` - Main model class with Com, CanIf, and PduR modules
- `Com` - Communication module with ComIPdus
- `CanIf` - CAN Interface module with channels and CanIfPduCfg configurations
- `PduR` - PDU Router module with source/destination PDUs and routing paths

## Example Usage Patterns
```java
// Get total ComIPdu count from Com module
int totalIPduCount = ecucDataModel.getCom().getComIPdus().size();

// Get total PduR PDU count from PduR using utility method
int totalPduCount = pdurExtractorUtil.getTotalPduCount(ecucDataModel.getPduR());
```
