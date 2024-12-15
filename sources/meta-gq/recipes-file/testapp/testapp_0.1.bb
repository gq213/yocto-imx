LICENSE = "CLOSED"

inherit externalsrc

EXTERNALSRC = "${BSPDIR}/sources/meta-gq/src/testapp"
EXTERNALSRC_BUILD = "${BSPDIR}/sources/meta-gq/src/testapp"

DEPENDS = "testlib"

do_install() {
	install -d ${D}/usr/bin/
	install -m 0755 testapp ${D}/usr/bin/
}

FILES:${PN} = "/"

PACKAGE_ARCH = "${MACHINE_SOCARCH}"
COMPATIBLE_MACHINE = "(mx8mp-nxp-bsp)"
