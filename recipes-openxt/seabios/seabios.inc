DESCRIPTION = "SeaBIOS"
HOMEPAGE = "http://www.coreboot.org/SeaBIOS"
LICENSE = "LGPLv3"
SECTION = "firmware"

SRC_URI = " \
    http://ftp.nluug.nl/os/Linux/virtual/ovirt/ovirt-3.5/src/${PN}/${PN}-${PV}.tar.gz \
"

S = "${WORKDIR}/${PN}-${PV}"

inherit xenclient

