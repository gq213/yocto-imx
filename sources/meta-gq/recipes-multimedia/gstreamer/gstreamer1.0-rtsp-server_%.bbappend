FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-install-examples.patch \
"

EXTRA_OEMESON:remove = " -Dexamples=disabled"
EXTRA_OEMESON:append = " -Dexamples=enabled"
