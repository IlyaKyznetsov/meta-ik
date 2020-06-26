LICENSE = "MIT"

require ik-image-ik-tiny.bb

# Wireless Central Regulatory Domain Agent for Mikroelektronika
IMAGE_INSTALL_append = " crda"

# for Transtelematica VM-18
IMAGE_INSTALL_append = " i2c-tools"

# Multimedia
IMAGE_INSTALL_append = " alsa-state alsa-utils"
IMAGE_INSTALL_append = " gstreamer1.0 gstreamer1.0-plugins-base"

# Qt
IMAGE_INSTALL_append = " qtmultimedia"

# Fonts Support
IMAGE_INSTALL_append = " fontconfig freetype"

# Images support
IMAGE_INSTALL_append = " libpng"

TOOLCHAIN_TARGET_TASK_remove = "packagegroup-qt5-toolchain-target-ik-tiny"
TOOLCHAIN_TARGET_TASK_append = " packagegroup-qt5-toolchain-target-ik-tiny-linuxfb"
