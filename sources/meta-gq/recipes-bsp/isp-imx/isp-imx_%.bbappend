FILESEXTRAPATHS:prepend := "${THISDIR}/imx219:"

SYSTEMD_AUTO_ENABLE = "disable"

SRC_URI += "file://0001-isp-imx-add-imx219.patch \
			file://0002-imx219-auto-focus.patch \
"

FILES_SOLIBS_VERSIONED += " \
    ${libdir}/libimx219.so \
"
