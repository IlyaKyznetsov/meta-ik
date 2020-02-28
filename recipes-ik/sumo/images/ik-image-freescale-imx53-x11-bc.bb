SUMMARY = "Freescale Image X11 Validator"

LICENSE = "MIT"

FEATURE_PACKAGES_tools-sdk = "packagegroup-core-sdk packagegroup-core-standalone-sdk-target"
FEATURE_PACKAGES_ssh-server-dropbear = "packagegroup-core-ssh-dropbear"
FEATURE_PACKAGES_ssh-server-openssh = "packagegroup-core-ssh-openssh"
FEATURE_PACKAGES_hwcodecs = "${MACHINE_HWCODECS}"

FEATURE_PACKAGES_x11 = "packagegroup-core-x11"
FEATURE_PACKAGES_x11-base = "packagegroup-core-x11-base"

#IMAGE_FEATURES_REPLACES_ssh-server-openssh = "ssh-server-dropbear"

MACHINE_HWCODECS ??= ""

CORE_IMAGE_BASE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

CORE_IMAGE_EXTRA_INSTALL ?= ""

IMAGE_INSTALL ?= "${CORE_IMAGE_BASE_INSTALL}"

inherit image

IMAGE_FEATURES_append = " splash"

IMAGE_FEATURES_append = " package-management"
IMAGE_FEATURES_append = " hwcodecs"

IMAGE_FEATURES_append = " ssh-server-openssh"

IMAGE_INSTALL_append = " mtd-utils"

IMAGE_INSTALL_append = " bash chkconfig tzdata localedef fontconfig iptables libpng freetype openssl"

#Qt
IMAGE_INSTALL_append = " qtbase qtserialport qtlocation quazip qtmultimedia"

# Multimedia
IMAGE_INSTALL_append = " alsa-state alsa-utils"
IMAGE_INSTALL_append = " gstreamer1.0 gstreamer1.0-plugins-base"

# Wireless Central Regulatory Domain Agent for Mikroelektronika
IMAGE_INSTALL_append = " crda"

IMAGE_INSTALL_append = " i2c-tools"

# rdepends on matchbox-wm
REQUIRED_DISTRO_FEATURES = "x11"
IMAGE_FEATURES_append = " x11"
# X11
IMAGE_INSTALL_append = " packagegroup-core-x11-xserver packagegroup-core-x11-utils"
IMAGE_INSTALL_append = " matchbox-wm xcb-util-wm xmodmap"
IMAGE_INSTALL_append = " dbus"

# Utilites
IMAGE_INSTALL_append = " ppp wvdial connman connman-client"
IMAGE_INSTALL_append = " usb-modeswitch usb-modeswitch-data"
IMAGE_INSTALL_append = " proftpd"

IMAGE_INSTALL_append = " mc"

ROOT_PASSWORD = "root1"
EXTRA_USERS_PARAMS = "usermod -p `openssl passwd ${ROOT_PASSWORD}` root;"
inherit extrausers

inherit populate_sdk_qt5_base
TOOLCHAIN_HOST_TASK_append = " nativesdk-packagegroup-qt5-toolchain-host"
TOOLCHAIN_TARGET_TASK_append = " ik-freescale-x11-packagegroup-qt5-toolchain-target"
