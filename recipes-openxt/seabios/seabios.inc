DESCRIPTION = "SeaBIOS"
HOMEPAGE = "http://www.coreboot.org/SeaBIOS"
LICENSE = "LGPLv3"
SECTION = "firmware"

SRC_URI = " \
    https://www.seabios.org/downloads/${PN}-${PV}.tar.gz \
"

S = "${WORKDIR}/${PN}-${PV}"

inherit xenclient

