# Copyright 2017-2022 NXP
 
DEPENDS = "zlib-native openssl-native"

SRC_URI = "${IMX_MKIMAGE_SRC};branch=${SRCBRANCH} \
           file://0001-iMX8M-soc.mak-use-native-mkimage-from-sysroot.patch \
           file://0001-LFU-641-capsule-Fix-build-break-due-to-bashism.patch \
"
IMX_MKIMAGE_SRC ?= "git://github.com/nxp-imx/imx-mkimage.git;protocol=https"
SRCBRANCH = "lf-6.1.55_2.2.0"
SRCREV = "c4365450fb115d87f245df2864fee1604d97c06a"

S = "${WORKDIR}/git"

BOOT_TOOLS = "imx-boot-tools"
SYSROOT_DIRS += "/boot"
