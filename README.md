# Kotlin-Simple-HTTP-Server

## Overview

This is simple Kotlin/JVM web server like Python SimpleHTTPServer and CGIHTTPServer.
Simply speaking, socket connection.

## Usage

1. Setup Kotlin compiler for using `kotlinc`
    * macOS: brew install kotlin
        * in my case, `/usr/local/Cellar/kotlin/1.2.71/bin/kotlinc` is the application. 
2. Execute the script
    * `kotlinc -script server.kts`

Then access to `localhost:8081` in the browser, and you can see the response.
