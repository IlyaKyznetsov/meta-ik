LICENSE = "MIT"

FEATURE_PACKAGES_tools-sdk = "packagegroup-core-sdk packagegroup-core-standalone-sdk-target"
FEATURE_PACKAGES_ssh-server-dropbear = "packagegroup-core-ssh-dropbear"
FEATURE_PACKAGES_ssh-server-openssh = "packagegroup-core-ssh-openssh"
FEATURE_PACKAGES_hwcodecs = "${MACHINE_HWCODECS}"

# Change ssh-server-openssh to ssh-server-dropbear
#IMAGE_FEATURES_REPLACES_ssh-server-openssh = "ssh-server-dropbear"

MACHINE_HWCODECS ??= ""

CORE_IMAGE_BASE_INSTALL = "packagegroup-core-boot"

CORE_IMAGE_EXTRA_INSTALL = ""

IMAGE_INSTALL = "${CORE_IMAGE_BASE_INSTALL}"

inherit image

IMAGE_FEATURES_append = " package-management"
IMAGE_FEATURES_append = " hwcodecs"

IMAGE_FEATURES_append = " ssh-server-openssh"
#IMAGE_FEATURES_append = " ssh-server-dropbear"

IMAGE_INSTALL_append = " mtd-utils openssl rsync update-rc.d iptables curl"

#Qt
IMAGE_INSTALL_append = " qtbase quazip qtserialport"

# 1---------------------------------------------------------------
# Wireless Central Regulatory Domain Agent for Mikroelektronika
IMAGE_INSTALL_append = " crda"

# for Transtelematica VM-18
IMAGE_INSTALL_append = " i2c-tools"

IMAGE_INSTALL_append = " bash"
IMAGE_INSTALL_append = " util-linux"
IMAGE_INSTALL_append = " tzdata"

# Fonts Support
IMAGE_INSTALL_append = " fontconfig freetype liberation-fonts"

# Images support
IMAGE_INSTALL_append = " libpng"
IMAGE_INSTALL_append = " mc"

# 2---------------------------------------------------------------
# Qt
IMAGE_INSTALL_append = " qtlocation"

# Dial-Up
#IMAGE_INSTALL_append = " ppp"
IMAGE_INSTALL_append = " ppp wvdial"
IMAGE_INSTALL_append = " usb-modeswitch usb-modeswitch-data"

# Ftp Server
IMAGE_INSTALL_append = " proftpd"

# Touchscreen Support
IMAGE_INSTALL_append=" tslib tslib-calibrate"

# 3---------------------------------------------------------------
# Multimedia
IMAGE_INSTALL_append = " alsa-state alsa-utils"
IMAGE_INSTALL_append = " gstreamer1.0 gstreamer1.0-plugins-base"

# Qt
IMAGE_INSTALL_append = " qtmultimedia"

ROOT_PASSWORD = "root1"
EXTRA_USERS_PARAMS = "usermod -p `openssl passwd ${ROOT_PASSWORD}` root;"
inherit extrausers

inherit populate_sdk_qt5_base
TOOLCHAIN_HOST_TASK_append = " nativesdk-packagegroup-qt5-toolchain-host"
TOOLCHAIN_TARGET_TASK_append = " packagegroup-qt5-toolchain-target-void"
