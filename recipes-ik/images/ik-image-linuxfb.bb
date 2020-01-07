SUMMARY = "Image with sysvinit, linuxfb, wvdial, vsftpd, openssh, qt"

LICENSE = "MIT"

#FEATURE_PACKAGES_x11 = "packagegroup-core-x11"
#FEATURE_PACKAGES_x11-base = "packagegroup-core-x11-base"
FEATURE_PACKAGES_tools-sdk = "packagegroup-core-sdk packagegroup-core-standalone-sdk-target"
FEATURE_PACKAGES_ssh-server-dropbear = "packagegroup-core-ssh-dropbear"
FEATURE_PACKAGES_ssh-server-openssh = "packagegroup-core-ssh-openssh"
FEATURE_PACKAGES_hwcodecs = "${MACHINE_HWCODECS}"

# IMAGE_FEATURES_REPLACES_foo = 'bar1 bar2'
# Including image feature foo would replace the image features bar1 and bar2
IMAGE_FEATURES_REPLACES_ssh-server-openssh = "ssh-server-dropbear"

# IMAGE_FEATURES_CONFLICTS_foo = 'bar1 bar2'
# An error exception would be raised if both image features foo and bar1(or bar2) are included

MACHINE_HWCODECS ??= ""

#CORE_IMAGE_BASE_INSTALL = '\
#    packagegroup-core-boot \
#   packagegroup-base-extended \
#    \
#    ${CORE_IMAGE_EXTRA_INSTALL} \
#    '

CORE_IMAGE_BASE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

CORE_IMAGE_EXTRA_INSTALL ?= ""

IMAGE_INSTALL ?= "${CORE_IMAGE_BASE_INSTALL}"

inherit image

IMAGE_FEATURES_append = " splash"
IMAGE_FEATURES_append = " hwcodecs"
IMAGE_FEATURES_append = " package-management"
IMAGE_FEATURES_append = " ssh-server-dropbear"

# Base minimal components
IMAGE_INSTALL_append = " chkconfig"
IMAGE_INSTALL_append = " tzdata localedef"
IMAGE_INSTALL_append = " fontconfig"
IMAGE_INSTALL_append= " iptables"
IMAGE_INSTALL_append = " libpng freetype openssl"

# Utilites
#IMAGE_INSTALL_append = " dbus"
IMAGE_INSTALL_append = " bash"
IMAGE_INSTALL_append = " wvdial"
IMAGE_INSTALL_append = " iftop"
IMAGE_INSTALL_append=" tslib tslib-calibrate"
#IMAGE_INSTALL_append = " pointercal"
#IMAGE_INSTALL_append = " networkmanager modemmanager"
#IMAGE_INSTALL_append = " ntp gpsd"
#IMAGE_INSTALL_append = " upower"
IMAGE_INSTALL_append = " mc"

# Servers
#IMAGE_INSTALL_append= " inetutils"
#IMAGE_INSTALL_append= " vsftpd"
IMAGE_INSTALL_append= " proftpd"


#Qt
IMAGE_INSTALL_append = " qtbase qtserialport qtmultimedia qtlocation quazip"

# Multimedia
IMAGE_INSTALL_append = " alsa-state alsa-utils"
#IMAGE_INSTALL_append = " gstreamer1.0"

# Fonts
#IMAGE_INSTALL_append = " liberation-fonts"

ROOT_PASSWORD = "root1"
EXTRA_USERS_PARAMS = "usermod -p `openssl passwd ${ROOT_PASSWORD}` root;"
inherit extrausers

inherit populate_sdk_qt5_base
TOOLCHAIN_HOST_TASK_append = " nativesdk-packagegroup-qt5-toolchain-host"
TOOLCHAIN_TARGET_TASK_append = " packagegroup-qt5-toolchain-target"
