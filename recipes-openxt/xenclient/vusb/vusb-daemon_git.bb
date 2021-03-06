DESCRIPTION = "Citrix USB Daemon for XenClient"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=4641e94ec96f98fabc56ff9cc48be14b"
DEPENDS = " libusb-compat xen libv4v libxcdbus xenclient-idl xenclient-rpcgen-native libevent libxcxenstore udev"
RDEPENDS_${PN} += "libxcxenstore"

PV = "0+git${SRCPV}"

SRCREV = "${AUTOREV}"
SRC_URI = "git://${OPENXT_GIT_MIRROR}/vusb-daemon.git;protocol=${OPENXT_GIT_PROTOCOL};branch=${OPENXT_BRANCH} \
           file://xenclient-vusb.initscript \
           "

EXTRA_OECONF += "--with-idldir=${STAGING_IDLDIR}"
# workaround for broken configure.in
EXTRA_OECONF += "--with-libexpat=${STAGING_LIBDIR}"
EXTRA_OECONF += "--with-libxenstore=${STAGING_LIBDIR}"
EXTRA_OECONF += "--with-rpcgen-templates=${STAGING_DATADIR_NATIVE}/xc-rpcgen-1.0/templates"

S = "${WORKDIR}/git"

inherit autotools xenclient update-rc.d pkgconfig

INITSCRIPT_NAME = "xenclient-vusb-daemon"
INITSCRIPT_PARAMS = "defaults 60"

do_install_append (){
        install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/xenclient-vusb.initscript \
		${D}/etc/init.d/xenclient-vusb-daemon
}
