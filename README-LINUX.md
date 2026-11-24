# Linux 3.0 — recovered SONIC base

This project keeps the recovered SONIC decompilation as the Android base and adds a local-agent layer instead of recreating the application.

## Local AI layer
- Thinker: Qwen3 4B IQ3_M GGUF, loaded by llama.cpp.
- Action/tool router: Cactus Needle 3 `.cact` runtime.
- Agent facade: `com.project.sonic.linux.runtime.LinuxAgent`.
- Models are downloaded into app-private storage on first local-agent initialization; they are intentionally not committed to GitHub.
- Existing accessibility, notification, voice interaction, OCR, camera, and Android action code remains in the recovered source tree.

## Build
Push the repository to GitHub and run **Actions → Build Linux Android → Run workflow**. The workflow builds the Android app and uploads a debug APK.

The first model preparation on the device needs internet access because the Qwen 4B (~1.96 GB) and Needle 3 weights are not bundled into the APK. After download, inference is local.

## Important
The recovered Java was produced by APK decompilation, not the original Kotlin/Java project. Therefore this is a reconstruction project: some decompiled classes can require manual compiler fixes before the first successful build. The workflow is designed to expose those errors rather than silently replacing the recovered code with a new implementation.
