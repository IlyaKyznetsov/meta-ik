LICENSE = "MIT"

require ik-image-ik-tiny.bb

# Wireless Central Regulatory Domain Agent for Mikroelektronika
IMAGE_INSTALL_append = " crda"

# for Transtelematica VM-18
IMAGE_INSTALL_append = " i2c-tools"

# Qt
IMAGE_INSTALL_append = " qtlocation"

# Dial-Up
IMAGE_INSTALL_append = " ppp wvdial"
IMAGE_INSTALL_append = " usb-modeswitch usb-modeswitch-data"

# Ftp Server
IMAGE_INSTALL_append = " proftpd"

# Fonts Support
IMAGE_INSTALL_append = " fontconfig freetype"

# Images support
IMAGE_INSTALL_append = " libpng"

# Touchscreen Support
IMAGE_INSTALL_append=" tslib tslib-calibrate"

TOOLCHAIN_TARGET_TASK_remove = "packagegroup-qt5-toolchain-target-ik-tiny"
TOOLCHAIN_TARGET_TASK_append = " packagegroup-qt5-toolchain-target-ik-tiny-linuxfb"
