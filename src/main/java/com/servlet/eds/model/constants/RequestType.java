package com.servlet.eds.model.constants;

// Enum for request types (states)
enum RequestType {
    INITIAL_NEW_OBJECT,
    INITIAL_EXISTING_OBJECT,
    IN_PROGRESS_CHANGES,
    FINAL_NEW_OBJECT,
    FINAL_EXISTING_OBJECT
}

