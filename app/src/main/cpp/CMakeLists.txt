cmake_minimum_required(VERSION 3.22.1)
project(linux_native)

set(LLAMA_CPP_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../../../third_party/llama.cpp")
set(CACTUS_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../../../../third_party/cactus")

# llama.cpp is required for the Linux runtime.
if(NOT EXISTS "${LLAMA_CPP_DIR}/CMakeLists.txt")
    message(FATAL_ERROR
        "llama.cpp is missing. Expected: ${LLAMA_CPP_DIR}/CMakeLists.txt")
endif()

set(LLAMA_BUILD_TESTS OFF CACHE BOOL "" FORCE)
set(LLAMA_BUILD_EXAMPLES OFF CACHE BOOL "" FORCE)
set(LLAMA_BUILD_SERVER OFF CACHE BOOL "" FORCE)

add_subdirectory("${LLAMA_CPP_DIR}" llama EXCLUDE_FROM_ALL)

add_library(linux_llama SHARED linux_llama_jni.cpp)
target_include_directories(linux_llama PRIVATE
    "${LLAMA_CPP_DIR}/include"
)
target_link_libraries(linux_llama PRIVATE
    llama
    log
    android
)

# Cactus Needle is required for the real tool/action runtime.
if(NOT EXISTS "${CACTUS_DIR}/include/cactus_engine.h")
    message(FATAL_ERROR
        "Cactus header missing: ${CACTUS_DIR}/include/cactus_engine.h")
endif()

if(NOT EXISTS "${CACTUS_DIR}/lib/arm64-v8a/libcactus.so")
    message(FATAL_ERROR
        "Cactus Android library missing: ${CACTUS_DIR}/lib/arm64-v8a/libcactus.so")
endif()

add_library(cactus_engine SHARED IMPORTED)

set_target_properties(cactus_engine PROPERTIES
    IMPORTED_LOCATION
    "${CACTUS_DIR}/lib/arm64-v8a/libcactus.so"
)

add_library(linux_cactus SHARED linux_cactus_jni.cpp)

target_include_directories(linux_cactus PRIVATE
    "${CACTUS_DIR}/include"
)

target_link_libraries(linux_cactus PRIVATE
    cactus_engine
    log
    android
)
