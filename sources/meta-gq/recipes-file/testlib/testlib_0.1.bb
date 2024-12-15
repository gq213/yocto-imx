LICENSE = "CLOSED"

inherit externalsrc

EXTERNALSRC = "${BSPDIR}/sources/meta-gq/src/testlib"
EXTERNALSRC_BUILD = "${BSPDIR}/sources/meta-gq/src/testlib"

do_install() {
	install -d ${D}/usr/include/
	install -d ${D}/usr/lib/
	install -m 0644 testlib.h ${D}/usr/include/
	install -m 0755 libtestlib.so ${D}/usr/lib/
}

FILES:${PN} = "/"

PACKAGE_ARCH = "${MACHINE_SOCARCH}"
COMPATIBLE_MACHINE = "(mx8mp-nxp-bsp)"
