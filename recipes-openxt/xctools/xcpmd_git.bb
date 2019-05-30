DESCRIPTION = "Power Management Daemon for OpenXT"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4641e94ec96f98fabc56ff9cc48be14b"
DEPENDS = "dbus xen pciutils libxcdbus libxcxenstore udev libnl yajl"

PV = "0+git${SRCPV}"

SRCREV = "${AUTOREV}"
SRC_URI = "git://${OPENXT_GIT_MIRROR}/xctools.git;protocol=${OPENXT_GIT_PROTOCOL};branch=${OPENXT_BRANCH} \
	   file://xcpmd.initscript \
"

<<<<<<< HEAD
EXTRA_OECONF += "--with-idldir=${STAGING_IDLDIR}"
EXTRA_OECONF += "--with-rpcgen-templates=${STAGING_DATADIR_NATIVE}/xc-rpcgen-1.0/templates"

=======
>>>>>>> upstream/stable-8
CFLAGS_prepend += " -I${STAGING_INCDIR}/libnl3 "

CFLAGS_append += " -Wno-unused-parameter -Wno-deprecated-declarations "

S = "${WORKDIR}/git/xcpmd"

ASNEEDED = ""

inherit autotools xenclient update-rc.d pkgconfig xc-rpcgen-c

INITSCRIPT_NAME = "xcpmd"
INITSCRIPT_PARAMS = "defaults 60"

do_install_append() {
# RJP TODO remove xenpmd from xenclient-tools clam bake
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/xcpmd.initscript ${D}${sysconfdir}/init.d/xcpmd
}
