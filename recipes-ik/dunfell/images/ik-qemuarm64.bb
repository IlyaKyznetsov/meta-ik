SUMMARY = "Based on image"

LICENSE = "MIT"

FEATURE_PACKAGES_tools-sdk = "packagegroup-core-sdk packagegroup-core-standalone-sdk-target"
FEATURE_PACKAGES_ssh-server-dropbear = "packagegroup-core-ssh-dropbear"
FEATURE_PACKAGES_ssh-server-openssh = "packagegroup-core-ssh-openssh"
FEATURE_PACKAGES_hwcodecs = "${MACHINE_HWCODECS}"

#IMAGE_FEATURES_REPLACES_ssh-server-openssh = "ssh-server-dropbear"

MACHINE_HWCODECS ??= ""

CORE_IMAGE_BASE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

CORE_IMAGE_EXTRA_INSTALL ?= ""

IMAGE_INSTALL ?= "${CORE_IMAGE_BASE_INSTALL}"

inherit image

# IMAGE_FEATURES_append = " splash"

IMAGE_FEATURES_append = " package-management"
IMAGE_FEATURES_append = " hwcodecs"

IMAGE_FEATURES_append = " ssh-server-openssh"

IMAGE_INSTALL_append = " mtd-utils openssl"

#IMAGE_INSTALL_append = " bash tzdata localedef fontconfig iptables libpng freetype openssl"
#IMAGE_INSTALL_append = " zip unzip"
#IMAGE_INSTALL_append = " curl rsync"
#IMAGE_INSTALL_append = " curlpp"

# QtCoreMinimal
IMAGE_INSTALL_append = " qtbase qtserialport quazip"

IMAGE_INSTALL_append = " i2c-tools"

# IMAGE_INSTALL_append = " swupdate"

# IMAGE_INSTALL_append = " mc"

ROOT_PASSWORD = "root1"
EXTRA_USERS_PARAMS = "usermod -p `openssl passwd ${ROOT_PASSWORD}` root;"
inherit extrausers

inherit populate_sdk_qt5_base
# TOOLCHAIN_HOST_TASK_append = " nativesdk-packagegroup-qt5-toolchain-host"
# TOOLCHAIN_TARGET_TASK_append = " ik-freescale-imx28-packagegroup-qt5-toolchain-target"