# Copyright (C) 2014 O.S. Systems Software LTDA.

DESCRIPTION = "Target packages for Qt5 SDK"
LICENSE = "MIT"

PACKAGE_ARCH = "${TUNE_PKGARCH}"
inherit packagegroup

PACKAGEGROUP_DISABLE_COMPLEMENTARY = "1"

RDEPENDS_${PN} += " \
    packagegroup-core-standalone-sdk-target \
    libsqlite3-dev \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-plugins \
    qtbase-staticdev \
    qtbase-tools \
    qtserialport-dev \
    qtserialport-mkspecs \
    qtserialbus-dev \
    qtserialbus-mkspecs \
"
RDEPENDS_${PN}_remove_toolchain-clang_riscv32 = "qttools-dev qttools-mkspecs qttools-staticdev qttools-tools qttools-plugins"
RDEPENDS_${PN}_remove_toolchain-clang_riscv64 = "qttools-dev qttools-mkspecs qttools-staticdev qttools-tools qttools-plugins"
