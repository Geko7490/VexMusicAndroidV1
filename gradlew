#!/bin/sh
# Simplified gradlew stub - real project uses full wrapper
# This wrapper delegates to gradle if installed, else errors gracefully
set -e
if [ -f "./gradle/wrapper/gradle-wrapper.jar" ]; then
  exec java -jar ./gradle/wrapper/gradle-wrapper.jar "$@"
else
  echo "Gradle wrapper jar not found - downloading..."
  # fallback: try system gradle
  if command -v gradle >/dev/null 2>&1; then gradle "$@"; else echo "Gradle not installed"; exit 1; fi
fi
