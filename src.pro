TEMPLATE = subdirs
OTHER_FILES += README

DISTRO_CONFIGS.path = conf/distro
DISTRO_CONFIGS.files = $$files($$PWD/conf/distro/*)
OTHER_FILES += $$DISTRO_CONFIGS.files

IMAGES_CONFIGS.path = recipes-ik/dunfell/images
IMAGES_CONFIGS.files += $$files($$PWD/recipes-ik/dunfell/images/*)
IMAGES_CONFIGS.files += $$files($$PWD/recipes-ik/zeus/images/*)
IMAGES_CONFIGS.files += $$files($$PWD/recipes-ik/sumo/images/*)
IMAGES_CONFIGS.files += $$files($$PWD/recipes-ik/pyro/images/*)
IMAGES_CONFIGS.files += $$files($$PWD/recipes-ik/fido/images/*)
OTHER_FILES += $$IMAGES_CONFIGS.files


PACKAGEGROUPS_CONFIGS.path = recipes-ik/dunfell/images
PACKAGEGROUPS_CONFIGS.files += $$files($$PWD/recipes-ik/dunfell/packagegroups/*)
PACKAGEGROUPS_CONFIGS.files += $$files($$PWD/recipes-ik/zeus/packagegroups/*)
PACKAGEGROUPS_CONFIGS.files += $$files($$PWD/recipes-ik/sumo/packagegroups/*)
PACKAGEGROUPS_CONFIGS.files += $$files($$PWD/recipes-ik/pyro/packagegroups/*)
PACKAGEGROUPS_CONFIGS.files += $$files($$PWD/recipes-ik/fido/packagegroups/*)
OTHER_FILES += $$PACKAGEGROUPS_CONFIGS.files

BUILD_DIR=$$PWD/../../../imx53/
message($$BUILD_DIR)
OTHER_FILES += \
    $$BUILD_DIR/conf/local.conf \
    $$BUILD_DIR/e.log.bb \
    $$BUILD_DIR/pn-buildlist \
    $$BUILD_DIR/task-depends.dot
