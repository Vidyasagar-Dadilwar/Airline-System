FROM maven:3.8-openjdk-17

WORKDIR /app

# Copy the project files
COPY . .
