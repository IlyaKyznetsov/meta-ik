LICENSE = "MIT"

require ik-image-ik-tiny-linuxfb.bb

# Multimedia
IMAGE_INSTALL_append = " alsa-state alsa-utils"
IMAGE_INSTALL_append = " gstreamer1.0 gstreamer1.0-plugins-base"

# Qt
IMAGE_INSTALL_append = " qtmultimedia"

TOOLCHAIN_TARGET_TASK_remove = "packagegroup-qt5-toolchain-target-ik-tiny"
TOOLCHAIN_TARGET_TASK_append = " packagegroup-qt5-toolchain-target-ik-tiny-linuxfb"
