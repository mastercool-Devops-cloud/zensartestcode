#!/bin/bash

# Variables
TOMCAT_SERVICE_NAME=tomcat
TOMCAT_PORT=8080

# Function to check if Tomcat is running
is_tomcat_running() {
    # Check if Tomcat process is running
    if pgrep -f $TOMCAT_SERVICE_NAME > /dev/null; then
        return 0
    else
        return 1
    fi
}

# Function to start Tomcat
start_tomcat() {
    echo "Starting Tomcat service..."
    sudo systemctl start $TOMCAT_SERVICE_NAME
    sleep 5  # Give it some time to start
}

# Check if Tomcat is running
if is_tomcat_running; then
    echo "Tomcat is already running."
else
    echo "Tomcat is not running."
    start_tomcat
    
    # Check again if Tomcat started successfully
    if is_tomcat_running; then
        echo "Tomcat started successfully."
    else
        echo "Failed to start Tomcat."
    fi
fi

