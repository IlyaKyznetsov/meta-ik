LICENSE = "MIT"

#FEATURE_PACKAGES_tools-sdk = "packagegroup-core-sdk packagegroup-core-standalone-sdk-target"
FEATURE_PACKAGES_ssh-server-dropbear = "packagegroup-core-ssh-dropbear"
FEATURE_PACKAGES_ssh-server-openssh = "packagegroup-core-ssh-openssh"

FEATURE_PACKAGES_hwcodecs = "${MACHINE_HWCODECS}"

# Change ssh-server-openssh to ssh-server-dropbear
#IMAGE_FEATURES_REPLACES_ssh-server-openssh = "ssh-server-dropbear"

MACHINE_HWCODECS ??= ""

CORE_IMAGE_BASE_INSTALL = "packagegroup-core-image-void"

CORE_IMAGE_EXTRA_INSTALL ?= ""

IMAGE_INSTALL ?= "${CORE_IMAGE_BASE_INSTALL}"

inherit image

# Package Manager
IMAGE_FEATURES_append = " package-management"
# HWcodecs
IMAGE_FEATURES_append = " hwcodecs"

#OpenSSH Server
IMAGE_FEATURES_append = " ssh-server-openssh"
#IMAGE_FEATURES_append = " ssh-server-dropbear"

# Base utilites
IMAGE_INSTALL_append = " bash update-rc.d tzdata localedef fontconfig iptables libpng freetype openssl"



ROOT_PASSWORD = "0"
EXTRA_USERS_PARAMS = "usermod -p `openssl passwd ${ROOT_PASSWORD}` root;"
inherit extrausers

#inherit populate_sdk_qt5_base
#TOOLCHAIN_HOST_TASK_append = " nativesdk-packagegroup-qt5-toolchain-host"
#TOOLCHAIN_TARGET_TASK_append = " ik-freescale-packagegroup-qt5-toolchain-target"
