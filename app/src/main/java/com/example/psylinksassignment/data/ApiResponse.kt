package com.example.psylinksassignment.data

data class ApiResponse(
    val message: String,
    val success: Boolean,
    val unsafe: Boolean,
    val domain: String,
    val ipAddress: String,
    val server: String,
    val contentType: String,
    val statusCode: Int,
    val pageSize: Int,
    val domainRank: Int,
    val dnsValid: Boolean,
    val parking: Boolean,
    val spamming: Boolean,
    val malware: Boolean,
    val phishing: Boolean,
    val suspicious: Boolean,
    val adult: Boolean,
    val riskScore: Int,
    val countryCode: String,
    val category: String,
    val domainAge: DomainAge,
    val redirected: Boolean,
    val languageCode: String,
    val finalUrl: String,
    val requestId: String
)

data class DomainAge(
    val human: String,
    val timestamp: Long,
    val iso: String
)
