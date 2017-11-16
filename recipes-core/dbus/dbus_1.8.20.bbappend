PR .= ".1"

DEPENDS += "libselinux"
DEPENDS_xenclient-syncvm += "libv4v"
RDEPENDS_${PN} += "libselinux"

EXTRA_OECONF_xenclient-syncvm += "--enable-v4v"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI += " \
    file://0001-Make-the-default-DBus-reply-timeout-configurable.patch \
    file://add-domid-authentication.patch \
    file://system.conf \
    file://v4v.patch \
    "

do_install_append() {
	install -m 0755 -d ${D}/etc
	install -m 0755 -d ${D}/etc/dbus-1
	install -m 0644 ${WORKDIR}/system.conf ${D}/etc/dbus-1
}
