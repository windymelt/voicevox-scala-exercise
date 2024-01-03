#!/bin/sh

set -exu

# linux, osx, windows
OS=linux

# x64, arm64
ARCH=x64

# target path to install dynamic libs
PREFIX=/usr/local/lib

cd $(dirname "$0")

curl -sSL -o download-script "https://github.com/VOICEVOX/voicevox_core/releases/download/0.14.5/download-${OS}-${ARCH}"
chmod u+x download-script
./download-script
# it inflates into ./voicevox_core/
sudo cp ./voicevox_core/libonnxruntime.so.1.13.1  ./voicevox_core/libvoicevox_core.so "${PREFIX}/"
sudo ln -s "${PREFIX}/libonnxruntime.so.1.13.1" "${PREFIX}/libonnxruntime.so"