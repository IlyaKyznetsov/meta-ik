LICENSE = "MIT"

FEATURE_PACKAGES_tools-sdk = "packagegroup-core-sdk packagegroup-core-standalone-sdk-target"
FEATURE_PACKAGES_ssh-server-dropbear = "packagegroup-core-ssh-dropbear"
FEATURE_PACKAGES_ssh-server-openssh = "packagegroup-core-ssh-openssh"
FEATURE_PACKAGES_hwcodecs = "${MACHINE_HWCODECS}"

#IMAGE_FEATURES_REPLACES_ssh-server-openssh = "ssh-server-dropbear"
IMAGE_FEATURES_REPLACES_ssh-server-openssh = "ssh-server-dropbear"

MACHINE_HWCODECS ??= ""

#CORE_IMAGE_BASE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"
#CORE_IMAGE_BASE_INSTALL = "packagegroup-core-boot"
CORE_IMAGE_BASE_INSTALL = "packagegroup-core-boot-ik-tiny"

CORE_IMAGE_EXTRA_INSTALL ?= ""

IMAGE_INSTALL ?= "${CORE_IMAGE_BASE_INSTALL}"

inherit image

IMAGE_FEATURES_append = " package-management"
#IMAGE_FEATURES_append = " hwcodecs"

#IMAGE_FEATURES_append = " ssh-server-openssh"
IMAGE_FEATURES_append = " ssh-server-dropbear"

IMAGE_INSTALL_append = " mtd-utils"

#Qt
#IMAGE_INSTALL_append = " qtbase qtserialport qtlocation quazip qtmultimedia"
IMAGE_INSTALL_append = " qtbase qtdeclarative qtxmlpatterns qtserialport"

# Wireless Central Regulatory Domain Agent for Mikroelektronika
#IMAGE_INSTALL_append = " crda"

#IMAGE_INSTALL_append = " i2c-tools"

ROOT_PASSWORD = "root1"
EXTRA_USERS_PARAMS = "usermod -p `openssl passwd ${ROOT_PASSWORD}` root;"
inherit extrausers

inherit populate_sdk_qt5_base
TOOLCHAIN_HOST_TASK_append = " nativesdk-packagegroup-qt5-toolchain-host"
TOOLCHAIN_TARGET_TASK_append = " packagegroup-qt5-toolchain-target-ik-tiny"
