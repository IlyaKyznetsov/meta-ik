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
    qtdeclarative-dev \
    qtdeclarative-mkspecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtdeclarative-qmlplugins', '', d)} \
    qtdeclarative-tools \
    qtdeclarative-staticdev \
    qttranslations-qtdeclarative \
    qtlocation-dev \
    qtlocation-mkspecs \
    qtlocation-plugins \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtlocation-qmlplugins', '', d)} \
    qttranslations-qtlocation \
    qtmultimedia-dev \
    qtmultimedia-mkspecs \
    qtmultimedia-plugins \
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'qtmultimedia-qmlplugins', '', d)} \
    qttranslations-qtmultimedia \
    qtserialport-dev \
    qtserialport-mkspecs \
    qtserialbus-dev \
    qtserialbus-mkspecs \
"
RDEPENDS_${PN}_remove_toolchain-clang_riscv32 = "qttools-dev qttools-mkspecs qttools-staticdev qttools-tools"
RDEPENDS_${PN}_remove_toolchain-clang_riscv64 = "qttools-dev qttools-mkspecs qttools-staticdev qttools-tools"
